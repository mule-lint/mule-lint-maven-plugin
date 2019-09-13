#!/usr/bin/env bash

read -p "Mule 4 still recomends java8 -- are you sure you are running java8? $(java -version) " yn
case $yn in
		[Yy]* ) echo 'Good'; ;;
		[Nn]* ) exit;;
		* ) echo "Please answer yes or no."; exit;;
esac


read -p "Is the version correct? $(head pom.xml | grep \<version\>) " yn
case $yn in
		[Yy]* ) echo 'Good'; ;;
		[Nn]* ) exit;;
		* ) echo "Please answer yes or no."; exit;;
esac

mvn clean package && gpg --use-agent --armor --detach-sign --output pom.xml.sig pom.xml && mvn deploy
