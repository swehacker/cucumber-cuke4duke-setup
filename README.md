```bash
***************************************************************************************
**                                                                                   **
** Project created by Patrik Falk <patrik@swehacker.se> 2010-10-21                 **
**                                                                                   **
** This is a Cucumber project that is built using Maven which will download and      **
** install Cucumber, Cuke4Duke and install the required Gems (Rubygems).             **
**                                                                                   **
***************************************************************************************

The features are:
1. Cucumber is used to drive BDD scenarios aginst the Web Application, using Cuke4Duke.
2. Using Maven profiles, it will be possible to run the same Web tests against different
   browsers.
3. Uses Firefox as the browser used to drive the web application. This can be changed
   easily to HtmlUnit, Chrome or Internet Explorer.  See below.
4. Unit tests are run separately to integration tests.

To use this project, install the Java SDK and Maven 2, then issue the following
two commands from the projects root folder:

mvn -Dcucumber.installGems=true cuke4duke:cucumber
mvn clean integration-test

On initial run there will be a *lot* of things downloaded from Maven repositories. You
should see the following as amongst the last lines of the Maven output:

[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESSFUL
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 8 seconds

*NOTE* When building the maven project for the first time there is a *LOT* of
cuke4duke dependencies downloaded, but just the first time. It takes a while, but only
the first time.  And now the weird part, if on the first run the Cucumber steps fail,
run 'mvn clean integration-test' again. This also only has to be done once.

If you want to change the browser used for driving the web site (default is Firefox) then
specify it on the command line with a Maven profile; firefox, htmlunit, ie and chrome are
valid profiles. For example, the following will run the test using HtmlUnit.

mvn clean integration-test -P htmlunit
```
