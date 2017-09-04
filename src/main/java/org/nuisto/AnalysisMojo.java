package org.nuisto;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.util.ArrayList;
import java.util.List;

@Mojo(name = "analyze-mule")
public class AnalysisMojo extends AbstractMojo {
  @Parameter(property = "analyze-mule.rules")
  private String rules;

  @Parameter(property = "analyze-mule.sources")
  private String sources;

  @Parameter(property = "analyze-mule.output")
  private String outputDirectory;

  public void execute() throws MojoExecutionException {
    getLog().info("Hello, world.");
    getLog().info("Rules are " + rules);
    getLog().info("Sources are " + sources);
    getLog().info("OutputDirectory is " + outputDirectory);

    List<String> args = new ArrayList<String>();
    args.add("-r");
    args.add(rules);

    args.add("-s");
    args.add(sources);

    args.add("-o");
    args.add(outputDirectory);

    new org.nuisto.MuleLint().run(args.toArray(new String[]{}));
    //this.getClass().getResourceAsStream("");


    //if we get a bad result, then throw org.apache.maven.plugin.MojoFailureException


    //catch any exceptions and throw org.apache.maven.plugin.MojoExecutionException if an unexpected problem occurs. Throwing this exception causes a "BUILD ERROR" message to be displayed.
  }
}
