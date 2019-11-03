package com.reni.task03.entity;

import java.util.*;

public class Wikipedia {
    private Map<Integer, Article> articles = new HashMap<>();
    private Map<Integer, Stack<Article>> reserveCopiesArchive = new HashMap<>();

    public void addArticle(Article article) {
        validateArticle(article, "add");
        checkIsTitleExist(article.getTitle());

        int id = article.getId();
        articles.put(id, article);
        System.out.println("New article with id=" + id + " was add");
    }

    public Article getArticleById(int id) {
        checkIsIdNotExist(id);
        return articles.get(id).copy();
    }

    public void updateArticle(Article article) {
        validateArticle(article, "update");
        int id = article.getId();
        String newTitle = article.getTitle();

        Article currentVersion = articles.get(id);
        String currentTitle = currentVersion.getTitle();
        if (!newTitle.equals(currentTitle)){
            checkIsTitleExist(newTitle);
        }
        Article versionForArchive = currentVersion.copy();

        currentVersion.setTitle(newTitle);
        currentVersion.setContent(article.getContent());

        Stack<Article> archive = reserveCopiesArchive.get(id);
        if (archive == null) {
            archive = new Stack<>();
        }
        archive.add(versionForArchive);
        reserveCopiesArchive.put(id, archive);
        System.out.println("Article with title=" + id + " was updated");
    }


    public void resetLastChangesInArticleById(int id) {
        checkIsIdNotExist(id);

        Stack<Article> archive = reserveCopiesArchive.get(id);
        if (archive == null || archive.empty()) {
            throw new IllegalArgumentException("Article already in its original state");
        }
        Article archiveVersion = archive.pop();
        Article currentVersion = articles.get(id);

        currentVersion.setTitle(archiveVersion.getTitle());
        currentVersion.setContent(archiveVersion.getContent());

        System.out.println("Last changes of article with id=" + id + " was reset");
    }

    private void validateArticle(Article article, String action){
        if(article == null) {
            throw new IllegalArgumentException("Article is null");
        }
        int id = article.getId();

        if ("add".equals(action)){
            if (articles.containsKey(id)) {
                throw new IllegalArgumentException("Article with such id is already exist: id=" + id);
            }
        }
        if ("update".equals(action)){
            checkIsIdNotExist(id);
        }

        String title = article.getTitle();
        if(title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Articles title is null");
        }
    }

    private void checkIsIdNotExist(int id) {
        if (!articles.containsKey(id)) {
            throw new IllegalArgumentException("Article with such id does not exist: id=" + id);
        }
    }

    private void checkIsTitleExist(String title) {
        articles.values().forEach(value -> {
            if(title.equals(value.getTitle())){
                throw new IllegalArgumentException("Article with such title is already exist: title=" + title);
            }
        });
    }

}
