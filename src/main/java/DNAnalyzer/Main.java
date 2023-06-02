/*
 * Copyright © 2023 DNAnalyzer. Some rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * You are entirely responsible for the use of this application, including any and all activities that occur.
 * While DNAnalyzer strives to fix all major bugs that may be either reported by a user or discovered while debugging,
 * they will not be held liable for any loss that the user may incur as a result of using this application, under any circumstances.
 *
 * For further inquiries, please reach out to contact@dnanalyzer.live
 */

package DNAnalyzer;

import DNAnalyzer.utils.ai.PathRouter;
import DNAnalyzer.utils.core.Utils;
import java.io.IOException;

/**
 * Main Class for the DNAnalyzer program.
 *
 * @author Piyush Acharya (@VerisimilitudeX)
 * @version 1.2.1
 * @see <a href= "https://www.genome.gov/about-genomics/fact-sheets/Genomic-Data-Science">Genomic
 *     Datasheet</a>
 */
public class Main {

  /**
   * Main method for the DNAnalyzer program (run this).
   *
   * @param args Command line arguments {@code @category} Main
   * @throws IOException
   * @throws InterruptedException
   */
  public static void main(final String[] args) throws InterruptedException, IOException {
    String apiKey = System.getenv("OPENAI_API_KEY");
    Utils.clearTerminal();
    if (apiKey == null) {
      PathRouter.regular(args);
    } else {
      PathRouter.runGptAnalysis(args, apiKey);
    }
  }
}
