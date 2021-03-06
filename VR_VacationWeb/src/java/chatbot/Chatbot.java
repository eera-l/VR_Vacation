/*
 * Chatbot.java
 * Handles chatbot logic.
 */
package chatbot;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Federica
 */
public class Chatbot {
    
    private List<String> faqs = new ArrayList<>();
    private List<String> policy;
    
    /* Main method for testing purposes
     */
    public static void main(String[] args) {
        Chatbot cb = new Chatbot();
        cb.readAllLines();
        System.out.println(cb.answer("fsdfsfsf"));
    }
    
    /* Reads all text from faq.txt and stores it in a list
     */
    public void readAllLines() {
        
        try {
            URL url = Chatbot.class.getResource("faq.txt");
            faqs = Files.readAllLines(new File(url.toURI()).toPath());
            //policy = Files.readAllLines(new File("policy.txt").toPath());
        
        } catch (IOException | URISyntaxException ioe) {
            ioe.printStackTrace();
        }
    }
    
    /* Separates user's query into keywords
     * and matches the corresponding question in the list
     * to its answer. Returns the answer.
     */
    public String answer(String query) {
        String ans = "";
        ArrayList<String> keywords = extractQueryKeywords(query);
        boolean found = false;
        
        for (int i = 0; i < faqs.size(); i++) {
            found = false;
            for (String keyword : keywords) {
                if (faqs.get(i).charAt(0) == 'Q' && faqs.get(i).contains(keyword) && !keyword.equals("Vacation")) {
                    if (faqs.get(i + 1).charAt(3) == 'Y' && faqs.get(i + 1).charAt(4) == 'e') {
                       ans = faqs.get(i + 1).substring(8);
                       found = true;
                       break;
                    } else if (faqs.get(i + 1).charAt(3) == 'N') {
                        ans = faqs.get(i + 1).substring(7);
                        found = true;
                        break;
                    } else {
                        ans = faqs.get(i + 1).substring(3);
                        found = true;
                        break;
                    }
                }
            }
            if (found) {
                break;
            }
        }
        
        if (!found) {
            ans = "Sorry, I didn't understand your question.";
        }
        return ans;        
    }
    
    /* Extracts keywords from user's query.
     */
    public ArrayList<String> extractQueryKeywords(String query) {
        
        ArrayList<String> keywords = new ArrayList<>();
        
        String[] s = query.split(" ");
        
        for (String ss : s) {
            if (ss.length() > 4) {
                keywords.add(ss);
            }
        }

        return keywords;
    }
}
