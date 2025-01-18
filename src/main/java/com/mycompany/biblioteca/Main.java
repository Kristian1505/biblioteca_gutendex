package com.mycompany.biblioteca;
import com.mycompany.biblioteca.model.BookData;
import com.mycompany.biblioteca.model.GutendexResponse;
import com.mycompany.biblioteca.service.ApiService;
import com.mycompany.biblioteca.service.ConsoleMenu;
import com.mycompany.biblioteca.service.JsonMapperService;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Instances
        ApiService apiService = new ApiService();
        //ConsoleMenu consoleMenu = new ConsoleMenu();
        //JsonMapperService jsonMapperService = new JsonMapperService();


        //consoleMenu.displayMenu();

        String url = "https://gutendex.com/books/?search=pride%20and%20prejudice";

        String jsonData = apiService.getApiData(url);
        System.out.println("jsonData: " + jsonData);

        System.out.println("\n::::: DATOS ::::: \n" + jsonData);

        //BookData bookData = jsonMapperService.getData(jsonData, BookData.class);
        //System.out.println("BookData: " + bookData);

        //GutendexResponse gutendexResponse = jsonMapperService.getData(jsonData, GutendexResponse.class);
        //System.out.println("Gutendex Response: " + gutendexResponse);

        //List<BookData> books = gutendexResponse.bookResults();
        //System.out.println("Books: " + books);

        //int n = 1;
        //for(BookData book : books){
        //    System.out.println("Id del libro: " + n + " " + book.id());
        //    n+=1;
        //}

        //System.out.println();


    }
}
