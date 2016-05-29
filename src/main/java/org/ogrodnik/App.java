package org.ogrodnik;

import org.ogrodnik.init.ConverterCsv2Sql;

/**
 *  Created by Piotr on 26.05.2016.
 *  Convert data.csv file to data.sql and data_test.sql for testing purposes
 */

public class App {
    public static void main(String[]args){
        ConverterCsv2Sql.convert("src/main/resources/data.csv", "src/main/resources/data.sql",-1);
        ConverterCsv2Sql.convert("src/main/resources/data.csv", "src/main/resources/data_test.sql",50);
    }
}


