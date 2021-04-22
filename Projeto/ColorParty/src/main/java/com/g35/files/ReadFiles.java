package com.g35.files;
import com.g35.data.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadFiles {
     public static List<BlockComposite> read(final List<BlockModel> list, String file) {
         List<BlockComposite> groupBlocks = new ArrayList<>();
         try {
            File myObj = new File(file);
            Scanner myReader = new Scanner(myObj);
            List<List<BlockComposite>> blockList = new ArrayList<>();
            int groupID = 0;
            int temp;
            int index = 0;
            int level = 1;
             switch (file) {
                 case "Arenas/Level_1/Pattern.txt":
                     level = 1;
                     break;
                 case "Arenas/Level_2/Pattern.txt":
                     level = 2;
                     break;
                 case "Arenas/Level_3/Pattern.txt":
                     level = 3;
                     break;
             }

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] tokens = data.split(" ");
                for (String token : tokens)
                {
                    temp = Integer.parseInt(token);
                    if (temp > groupID)
                    {
                        groupID = temp;
                        List<BlockComposite> blockModels = new ArrayList<>();
                        blockList.add(blockModels);
                    }

                    (blockList.get(temp - 1)).add(list.get(index));
                    index++;
                }
            }
            myReader.close();

            for(List<BlockComposite> blocks_list : blockList){
                groupBlocks.add(new BlockGroup(blocks_list, level));
            }
         } catch (FileNotFoundException e) {
             System.out.println("An error occurred.");
             e.printStackTrace();
         }
        return groupBlocks;
    }
}
