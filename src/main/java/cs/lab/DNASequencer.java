package cs.lab;

import java.util.List;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class  DNASequencer {

    static final Logger logger = Logger.getLogger(DNASequencer.class.getName());
    public DNASequencer() {
        logger.info("Starting sequencer...");
    }

    public String calculate(List<String> part){
        String minimunSequence = part.get(0);


        for(int i = 0; i < part.size(); i++){
            String genoma = part.get(i);
            Pattern word = Pattern.compile(genoma);
            Matcher match = word.matcher(part.get(i+1));
            while (!match.find()) {
                genoma.substring(1);
            }
            int endIndx = match.end();
            
            for(int j = endIndx; j < part.get(i+1).length(); j++)
                minimunSequence += part.get(i+1).charAt(j);  
        }
        return minimunSequence;
    }
}
