package com.reni.task03;

import com.reni.task03.entity.Article;

public class ArticleApp {
    private static Wikipedia wikipedia = new Wikipedia();

    public static void main(String[] args) {
        Article articleOne = new Article( 1,"OOP", "Article one content");
        wikipedia.addArticle(articleOne);
        try {
            wikipedia.addArticle(new Article(2,"OOP", "Article two content"));
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

        Article articleTwo = new Article(2,"JAVA", "Article two content");
        wikipedia.addArticle(articleTwo);
        Article articleCopy = wikipedia.getArticleById(2);

        System.out.println(articleCopy.equals(articleTwo)); // true
        System.out.println(articleCopy == articleTwo); // false

        articleCopy.setContent("New content for copy of articleTwo");
        wikipedia.updateArticle(articleCopy);

        System.out.println(articleCopy.getContent().equals(articleTwo.getContent())); // true

        wikipedia.resetLastChangesInArticleById(2);

        System.out.println(articleCopy.getContent().equals(articleTwo.getContent())); // false
    }
}
