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
    public String calculate(final List<String> part) throws TooManyLinesException, TooLargeSubsequenceException {        
        if(part.size() > 160000)
            throw new TooManyLinesException("too much subsquences");
        
        StringBuilder minimunSequence = new StringBuilder(part.get(0));
        
        int endIndex = 0;
        
        for(int i = 0; i < part.size()-1; i++){
        
        if(part.get(i).length() > 200)
            throw new TooLargeSubsequenceException("too large susequence");
        
	    Boolean wordFounded = false;
	    String genoma = part.get(i);
            while (Boolean.FALSE.equals(wordFounded)) {
                final Pattern word = Pattern.compile(genoma);
		final Matcher match = word.matcher(part.get(i+1));
		if(match.find()){
	        	wordFounded = true;
			endIndex = match.end();
		}else{
			genoma = genoma.substring(1);
		}
	    }
            for(int j = endIndex; j < part.get(i+1).length(); j++)
                minimunSequence.append(part.get(i+1).charAt(j));  
        }
            
        return minimunSequence.toString();
    
    }
}
