FROM tomee

RUN rm -rf /usr/local/tomee/webapps/ROOT

COPY build/libs/budgetWorking-1.0-SNAPSHOT.war /usr/local/tomee/webapps/ROOT.war
