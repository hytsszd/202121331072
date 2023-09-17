package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class main {
    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("请提供原文文件路径、抄袭版论文文件路径和答案文件路径");
            return;
        }

        String origFilePath = args[0];
        String plagiarizedFilePath = args[1];
        String answerFilePath = args[2];

        try {
            String origContent = readFile(origFilePath);
            String plagiarizedContent = readFile(plagiarizedFilePath);

            double similarity = calculateSimilarity(origContent, plagiarizedContent);
            writeAnswer(similarity, answerFilePath);

            System.out.println("论文查重完成！重复率为：" + similarity);
        } catch (IOException e) {
            System.out.println("发生IO异常：" + e.getMessage());
        }
    }

    private static String readFile(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = reader.readLine()) != null) {
            content.append(line).append("\n");
        }
        reader.close();
        return content.toString();
    }

    private static double calculateSimilarity(String origContent, String plagiarizedContent) {
        // 在这里实现计算相似度的逻辑，可以使用编辑距离算法或者其他算法
        // 以下仅为示例，使用简单的编辑距离算法

        int[][] dp = new int[origContent.length() + 1][plagiarizedContent.length() + 1];

        for (int i = 0; i <= origContent.length(); i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j <= plagiarizedContent.length(); j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= origContent.length(); i++) {
            for (int j = 1; j <= plagiarizedContent.length(); j++) {
                if (origContent.charAt(i - 1) == plagiarizedContent.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
                }
            }
        }

        int maxLen = Math.max(origContent.length(), plagiarizedContent.length());
        int editDistance = dp[origContent.length()][plagiarizedContent.length()];
        return 1 - (double) editDistance / maxLen;
    }

    private static void writeAnswer(double similarity, String filePath) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
        writer.write(String.format("%.2f", similarity));
        writer.close();
    }
}