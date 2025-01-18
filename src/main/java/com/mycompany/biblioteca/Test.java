package com.mycompany.biblioteca;

import com.mycompany.biblioteca.service.ApiService;

public class Test {

    public static void main(String[] args) {

        // Instances
        ApiService apiService = new ApiService();

        // Attributes
        String url = "https://gutendex.com/books?search=pride%20and%20prejudice";
        String url2 = "https://gutendex.com/books/?search=pride%20and%20prejudice";
        String url3 = "https://gutendex.com/books/1342/";

        String json = apiService.getApiData(url);
        String json2 = apiService.getApiData(url2);
        String json3 = apiService.getApiData(url3);


        // Test 1: Just print the Json using apiService.getApiData:
        System.out.println("Printing Json from apiService.getApidata(https://gutendex.com/books?search=pride%20and%20prejudice): \n" + json);
        System.out.println("Printing Json2 from apiService.getApidata(https://gutendex.com/books/?search=pride%20and%20prejudice): \n" + json2);
        System.out.println("Printing Json3 from apiService.getApidata(https://gutendex.com/books/1342/): \n" + json3);

    }
}
