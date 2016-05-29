package org.ogrodnik.init;

import java.io.*;

/**
 * Created by Piotr on 26.05.2016.
 */
public class ConverterCsv2Sql {

    /**
     * Convert csv file to sql file
     *
     * @param fileIn  - input file name
     * @param fileOut - output file name
     * @param head  - number of line from beginnning
     */
    public static void convert(String fileIn, String fileOut, int head) {

        assert fileIn != null;
        assert fileOut != null;

        BufferedReader input = null;
        BufferedWriter output = null;

        try {
            input = new BufferedReader(new FileReader(new File(fileIn)));
            output = new BufferedWriter(new FileWriter(new File(fileOut)));
            String line;
            String[] st;
            input.readLine(); // omitting header of CSV file
            int idx = 0;
            while ( ((head<=0 ) || ( idx<head  )) && ((line = input.readLine()) != null) ) {
                st = line.split(",");
                String[] date = st[0].split("/");
                String formattedDate = date[2] + "-" + date[1] + "-" + date[0];
                StringBuffer cmd = new StringBuffer();
                cmd.append("INSERT INTO Quote")
                        .append(" (id, quoteDate, quoteValue) VALUES (")
                        .append(++idx)
                        .append(", '")
                        .append(formattedDate)
                        .append("', ")
                        .append(st[1])
                        .append(");")
                        .append("\n");
                output.write(cmd.toString());
            }
        } catch (IOException e) {

        } finally {
            try {
                if (input != null) input.close();
                if (output != null) output.close();
            } catch (IOException d) {

            } finally {
            }
        }

    }

}
