

import java.io.*;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;



public class WordChains {

    /**
     * Data structure that will store informations of connected words.
     * */

    protected static class Word {
        protected String value;

        protected Word from;
        protected int graphId = 0;
        
        public Word(String value){
            this.value = value;
        };

        public void setGraphId(int id) {
            graphId = id;
        };
        
        @Override
        public int hashCode() {
            return value.hashCode();
        };

        @Override
        public String toString(){
            return  this.value+" graph "+graphId+" connected to "+ (from==null?"Root":from);
        };
        
        public String getValue(){
            return value;
        }

        @Override
        public boolean equals(Object toObj){
            return ((Word)toObj).value.equals(value);
        };
    };

  /**
    *  2 words with the same graph id are connected
    * */
    public static boolean areConnected(String left,String right){
        System.out.println("Left word "+words.get(left));
        System.out.println("Right word "+words.get(right));
        return words.get(left).graphId==words.get(right).graphId;
    };

    public final static StringBuffer sb = new StringBuffer();

    public static void addToDictionary(final String newWord){
        Word newWordObj = new Word(newWord);
        words.put(newWordObj.value,newWordObj);
        int length = newWordObj.value.length();
        if(wordsByLenght.get(length) == null){
            wordsByLenght.put(length,new HashMap<String,Word>());
        }
        wordsByLenght.get(length).put(newWord, newWordObj);
    }

    /**
     *  Utility to display all connected words for a given graph id
     * */
    public static void displayConnectedWords(int graphid){
       for(Word word : wordsByGraph.get(graphid)){
            System.out.println(word.getValue());
        }
    }

    static Map<String,Word> words = new HashMap<String,Word>(200000);
    static Map<Integer,Map<String,Word>> wordsByLenght = new HashMap<Integer,Map<String,Word>>(30);
    static Set<Character> alphabet = new HashSet<Character>(27);
    static Map<Integer,List<Word>> wordsByGraph = new TreeMap<Integer,List<Word>>();


    public static void main(String[] args) throws IOException {

        //By default it takes /usr/share/dict/words
        String dictionaryLocation = (args.length==0 ? "/usr/share/dict/words" : args[0]);
        System.out.println(" Using dictionary " + dictionaryLocation);
        BufferedReader reader = null;
        try{
            reader = new BufferedReader(new FileReader(dictionaryLocation));
        } catch (FileNotFoundException e) {
            System.err.println("File " + dictionaryLocation + " not found");
        }

        MemoryMXBean memory = ManagementFactory.getMemoryMXBean();
        System.out.println("Memory index start "+memory.getHeapMemoryUsage().toString());
        long start = System.currentTimeMillis();
        String strLine;
        int wordCount = 0;
        int maxWordLenght = 0;
        try {
            while ((strLine = reader.readLine()) != null)   {
                strLine = strLine.toLowerCase();
                addToDictionary(strLine);
                wordCount++;
                maxWordLenght = Math.max(maxWordLenght,strLine.length());
                for(int i = 0;i<strLine.length();i++){
                     alphabet.add(strLine.charAt(i));
                }
            }
        } catch (IOException e) {
            System.err.println("File " + dictionaryLocation + " not found");
        }

        int graphidCounter = 0;
        System.out.println("Letters in alphabet "+alphabet.size());
        for(int i = 1;i<maxWordLenght+1;i++){
            Map<String,Word> wordsLevel = wordsByLenght.get(i);
            if(wordsLevel!= null){
                for(Word word : wordsLevel.values() ){
                    outer:
                    if(word.graphId == 0){
                        for(int k = 0; k<word.value.length(); k++){
                                String value = sb.
                                    append(word.value.substring(0, k)).
                                    append(word.value.substring(k + 1,word.value.length())).
                                    toString();
                                if(words.get(value)!=null){
                                    word.setGraphId(words.get(value).graphId);
                                    word.from = words.get(value);
                                    wordsByGraph.get(words.get(value).graphId).add(word);
                                    sb.delete(0, sb.length());
                                    break outer;
                                }
                                sb.delete(0, sb.length());
                            for(Character currentChar : alphabet){
                                value = sb.
                                        append(word.value.substring(0, k)).
                                        append(currentChar).
                                        append(word.value.substring(k + 1,word.value.length())).
                                        toString();
                                if(words.get(value)!=null && words.get(value).graphId != 0){
                                    if(word.graphId == 0  ){
                                        word.setGraphId(words.get(value).graphId);
                                        word.from = words.get(value);
                                        if(wordsByGraph.get(words.get(value).graphId)==null){
                                            System.out.println("graph id "+words.get(value).graphId);
                                        }
                                        wordsByGraph.get(words.get(value).graphId).add(word);
                                    }else if(word.graphId != words.get(value).graphId) {
                                        //this means that we need to connect the 2 disconnected graph with the min graph id
                                        int maxGraphId = Math.max(word.graphId,words.get(value).graphId);
                                        int minGraphId = Math.min(word.graphId,words.get(value).graphId);
                                        //we update the words that have the max graph if with the min graph id
                                        for(Word wordToUpdate : wordsByGraph.get(maxGraphId)){
                                            wordToUpdate.setGraphId(minGraphId);
                                        }
                                    }
                                }
                                sb.delete(0, sb.length());
                            }
                        }
                        if(word.graphId == 0){
                            graphidCounter++;
                            word.setGraphId(graphidCounter);
                            wordsByGraph.put(graphidCounter, new ArrayList<Word>());
                            wordsByGraph.get(graphidCounter).add(word);
                        }
                        sb.delete(0, sb.length());
                    }
                }
            }
        }

        System.out.println("memory index end "+memory.getHeapMemoryUsage().toString());
        System.out.println("Time spent "+(System.currentTimeMillis()-start)/1000+" seconds");
        System.out.println("Done indexing "+wordCount+" words.");
        System.out.println("Distinct graph count "+graphidCounter);
        System.out.println("cat and dog "+areConnected("cat","dog"));
        System.out.println("demonic and umbrella "+areConnected("demonic","umbrella"));

        /*
        * Reading the input
        * */
        System.out.println("Enter a line of text (type 'quit' to exit): ");
        InputStreamReader converter = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(converter);
        String curLine = "";
        while (!(curLine.equals("quit"))){
            curLine = in.readLine();
            if (!(curLine.equals("quit"))){
                String[] inputs =curLine.split(" ");
                if(inputs.length<2){
                    System.out.println("2 input are required ");
                }
                System.out.println("Answer "+areConnected(inputs[0].toLowerCase(), inputs[1].toLowerCase()));
            }
        }
    }
}
