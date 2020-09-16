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
	int endIndex = 0;
        for(int i = 0; i < part.size()-1; i++){
            
	    Boolean wordFounded = false;
	    String genoma = part.get(i);
            while (!wordFounded) {
                Pattern word = Pattern.compile(genoma);
		Matcher match = word.matcher(part.get(i+1));
		if(match.find()){
	        	wordFounded = true;
			endIndex = match.end();
		}else{
			genoma = genoma.substring(1);
		}
	    }
            for(int j = endIndex; j < part.get(i+1).length(); j++)
                minimunSequence += part.get(i+1).charAt(j);  
        }
		
        return minimunSequence;
    
    }
}
