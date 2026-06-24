package com.track.track.service;

import com.track.track.dto.CodeChefStatsDto;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

@Service
public class CodeChefService {

    public CodeChefStatsDto getCodeChefStats(String username) {

        try {

            String url = "https://www.codechef.com/users/" + username;

            Document doc = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0")
                    .timeout(10000)
                    .get();

            String rating = extract(doc, "rating-number");
            String highest = extractHighest(doc);
            String solved = extractSolved(doc);
            String contests = extractContest(doc);
            String lastActive = extractLastActive(doc);
            String globalRank = extractGlobalRank(doc);
            String stars = extractStars(doc);
            String division = extractDivision(doc);

            String countryRank = extractCountryRank(doc);

            return new CodeChefStatsDto(
                    rating, highest, globalRank, countryRank,
                    solved, contests, lastActive, stars, division
            );

        } catch (Exception e) {
            return new CodeChefStatsDto(
                    "N/A","N/A","N/A","N/A","N/A","N/A","N/A","N/A","N/A"
            );
        }
    }

    // ---------------- COMMON EXTRACTOR ----------------

    private String extract(Document doc, String className) {
        try {
            return doc.getElementsByClass(className)
                    .first()
                    .text()
                    .trim();
        } catch (Exception e) {
            return "N/A";
        }
    }

    // ---------------- HIGHEST RATING ----------------

    private String extractHighest(Document doc) {
        try {
            String text = doc.text();

            int index = text.indexOf("Highest Rating");
            if (index == -1) return "N/A";

            return text.substring(index, Math.min(index + 50, text.length()))
                    .replaceAll("[^0-9]", " ")
                    .trim()
                    .split("\\s+")[0];

        } catch (Exception e) {
            return "N/A";
        }
    }

    // ---------------- TOTAL PROBLEMS SOLVED ----------------

    private String extractSolved(Document doc) {
        try {
            String text = doc.text();

            int index = text.indexOf("Total Problems Solved");
            if (index == -1) return "N/A";

            return text.substring(index, Math.min(index + 60, text.length()))
                    .replaceAll("[^0-9]", " ")
                    .trim()
                    .split("\\s+")[0];

        } catch (Exception e) {
            return "N/A";
        }
    }

    // ---------------- CONTESTS ----------------

    private String extractContest(Document doc) {
        try {
            String text = doc.text();

            int index = text.indexOf("Contests");
            if (index == -1) return "N/A";

            return text.substring(index, Math.min(index + 40, text.length()))
                    .replaceAll("[^0-9]", " ")
                    .trim()
                    .split("\\s+")[0];

        } catch (Exception e) {
            return "N/A";
        }
    }

    // ---------------- LAST ACTIVE ----------------

    private String extractLastActive(Document doc) {
        try {
            String html = doc.html();
            String text = doc.text().replaceAll("\\s+", " ");

            int htmlIndex = html.toLowerCase().indexOf("last active");

            if (htmlIndex != -1) {
                String part = html.substring(htmlIndex, Math.min(htmlIndex + 120, html.length()));
                return part.replaceAll("<[^>]*>", "")
                        .replaceAll("(?i)last active", "")
                        .replace(":", "")
                        .trim();
            }

            int textIndex = text.toLowerCase().indexOf("last active");

            if (textIndex != -1) {
                String part = text.substring(textIndex, Math.min(textIndex + 80, text.length()));
                return part.replaceAll("(?i)last active", "")
                        .replace(":", "")
                        .trim();
            }

            return "N/A";

        } catch (Exception e) {
            return "N/A";
        }
    }

    // ---------------- ⭐ STARS ----------------

    private String extractStars(Document doc) {
        try {
            // Star is shown next to username like "1★b23bec046kart"
            // or in the rating section as a star icon
            Elements starElements = doc.select(".rating");
            for (Element el : starElements) {
                String text = el.text();
                long count = text.chars().filter(c -> c == '★').count();
                if (count > 0) return "★".repeat((int) count);
            }

            // Fallback: count ★ in full page but only in rating context
            String ratingSection = "";
            Elements ratingBox = doc.select(".rating-number");
            if (!ratingBox.isEmpty()) {
                Element parent = ratingBox.first().parent();
                if (parent != null) ratingSection = parent.text();
            }

            long starCount = ratingSection.chars()
                    .filter(c -> c == '★').count();
            if (starCount > 0) return "★".repeat((int) starCount);

            // Rating-based fallback
            String ratingText = doc.select(".rating-number").text().trim();
            if (!ratingText.isEmpty()) {
                int rating = Integer.parseInt(
                        ratingText.replaceAll("[^0-9]", "")
                );
                if (rating >= 2500) return "★★★★★★★";
                if (rating >= 2200) return "★★★★★★";
                if (rating >= 1800) return "★★★★★";
                if (rating >= 1600) return "★★★★";
                if (rating >= 1400) return "★★★";
                if (rating >= 1200) return "★★";
                return "★";
            }

            return "N/A";
        } catch (Exception e) {
            return "N/A";
        }
    }

    // ---------------- 🌍 GLOBAL RANK ----------------

    private String extractGlobalRank(Document doc) {
        try {
            Elements rankDivs = doc.select(".rating-ranks");
            if (!rankDivs.isEmpty()) {
                Element firstDiv = rankDivs.get(0);
                for (Element li : firstDiv.select("li")) {
                    if (li.text().toLowerCase().contains("global rank")) {
                        String num = li.select("strong").text()
                                .replaceAll("[^0-9]", "").trim();
                        if (!num.isEmpty()) return num;
                    }
                }
            }
            return "N/A";
        } catch (Exception e) {
            return "N/A";
        }
    }

    private String extractCountryRank(Document doc) {
        try {
            Elements rankDivs = doc.select(".rating-ranks");
            if (!rankDivs.isEmpty()) {
                Element firstDiv = rankDivs.get(0);
                for (Element li : firstDiv.select("li")) {
                    if (li.text().toLowerCase().contains("country rank")) {
                        String num = li.select("strong").text()
                                .replaceAll("[^0-9]", "").trim();
                        if (!num.isEmpty()) return num;
                    }
                }
            }
            return "N/A";
        } catch (Exception e) {
            return "N/A";
        }
    }

    private String extractDivision(Document doc) {
        try {
            String text = doc.text();

            java.util.regex.Matcher matcher =
                    java.util.regex.Pattern.compile("(Div\\s*[1-4])",
                                    java.util.regex.Pattern.CASE_INSENSITIVE)
                            .matcher(text);

            if (matcher.find()) {
                return matcher.group(1);
            }

            return "N/A";

        } catch (Exception e) {
            return "N/A";
        }
    }
}