#!/bin/bash

JAVA_OPTS="-server -Xms32m -Xmx200m -Dfile.encoding=UTF-8"
#JAVA_OPTS="$JAVA_OPTS -Djava.ext.dirs=~/Documents/lib/"
export JAVA_OPTS

DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"

echo "Building Parking lot"
mvn clean package
echo "ENTER INPUT TO EXECUTE THE PROJECT:"
eval "java -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=1044 -jar $DIR/target/ParkingLot_Arpita-0.0.1-SNAPSHOT-jar-with-dependencies.jar $1"
