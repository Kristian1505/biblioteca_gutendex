package com.mycompany.biblioteca.service;
import com.mycompany.biblioteca.model.BookData;
import com.mycompany.biblioteca.model.GutendexResponse;

import java.util.List;
import java.util.Scanner;

public class ConsoleMenu {

    Scanner scanner = new Scanner(System.in);
    ApiService apiService = new ApiService();
    JsonMapperService jsonMapperService = new JsonMapperService();

    private String URL_BASE = "https://gutendex.com/books/?search=";



    public void displayMenu(){


        System.out.println("==============================\n" +
                "Bienvenido al Catálogo de Libros\n" +
                "==============================\n" +
                "\n" +
                "1. Buscar un libro por título\n" +
                "2. Buscar un libro por autor\n" +
                "3. Buscaer un libro por ID\n" +
                "4. Ver búsquedas recientes\n" +
                "5. Salir\n" +
                "\n" +
                "Por favor, selecciona una opción ingresando el número correspondiente:");

        //int option = scanner.nextInt();
        int option = 3;

        switch (option){
            case 1:
                searchBookByTitle();
                break;
            case 2:
                searchBookByAuthor();
                break;
            case 3:
                searchBookByID();
                break;
            case 4:
                System.out.println("Búsquedas recientes: ");
                break;
            case 5:
                System.out.println("... Saliendo de la app ... ");
                break;
        }
    }

    private void searchBookByTitle(){

        System.out.println("Escribe el nombre del libro deseado: ");
        String bookTitle = scanner.nextLine();
        String url = URL_BASE + bookTitle.replace(" ", "%20");
        String json = apiService.getApiData(url);

        if (json == null || json.isEmpty()) {
            System.out.println("La respuesta de la API está vacía o es nula.");
            return;
        }

        GutendexResponse gutendexResponse = jsonMapperService.getData(json, GutendexResponse.class);
        List<BookData> books = gutendexResponse.bookResults();

        int n = 1;
        for (BookData book : books){
            System.out.println(" ");
            System.out.println("Libro número " + n + ":");
            System.out.println("ID: " + book.id());
            System.out.println("Título: " + book.title());
            System.out.println("Datos del autor: " + book.authors());
            System.out.println("Datos del idioma: " + book.languages());
            System.out.println("Géneros relacionados: " + book.subjects());
            System.out.println("Número de veces descargado: " + book.downloadCount());
            n+=1;

        }

    }

    private void searchBookByAuthor(){

        System.out.println("Escribe el nombre del autor: ");
        String bookTitle = scanner.nextLine();
        String url = URL_BASE + bookTitle.replace(" ", "%20");
        String json = apiService.getApiData(url);

        if (json == null || json.isEmpty()) {
            System.out.println("La respuesta de la API está vacía o es nula.");
            return;
        }

        GutendexResponse gutendexResponse = jsonMapperService.getData(json, GutendexResponse.class);
        List<BookData> books = gutendexResponse.bookResults();

        int n = 1;
        for (BookData book : books){
            System.out.println(" ");
            System.out.println("Libro número " + n + ":");
            System.out.println("ID: " + book.id());
            System.out.println("Título: " + book.title());
            System.out.println("Datos del autor: " + book.authors());
            System.out.println("Datos del idioma: " + book.languages());
            System.out.println("Géneros relacionados: " + book.subjects());
            System.out.println("Número de veces descargado: " + book.downloadCount());
            n+=1;

        }

    }

    private void searchBookByID() {

        System.out.println("Ingresa el ID: ");
        String bookId = scanner.nextLine();
        String URL_BASE_ID = "https://gutendex.com/books/";
        String url = URL_BASE_ID + bookId + "/";
        System.out.println("------> " + url);
        String json = apiService.getApiData(url);

        if (json == null || json.isEmpty()) {
            System.out.println("La respuesta de la API está vacía o es nula.");
            return;
        }

        BookData book = jsonMapperService.getData(json, BookData.class);

        System.out.println("ID: " + book.id());
        System.out.println("Título: " + book.title());
        System.out.println("Datos del autor: " + book.authors());
        System.out.println("Datos del idioma: " + book.languages());
        System.out.println("Géneros relacionados: " + book.subjects());
        System.out.println("Número de veces descargado: " + book.downloadCount());

        }

    }