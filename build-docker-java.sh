#!/bin/bash
mvn -Pdocker-java clean spring-boot:build-image $1
