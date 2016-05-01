#!/bin/bash -xe

exec bin/kotlins -cp `./bin/mvncp net.htmlparser.jericho:jericho-html:3.4` src/main/bootstrap/SchemaGen.kt
