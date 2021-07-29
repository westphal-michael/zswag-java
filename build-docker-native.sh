#!/bin/bash
mvn -Pdocker-native clean spring-boot:build-image $1
