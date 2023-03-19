package com.kotlin.dojo

import org.junit.platform.suite.api.SelectPackages
import org.junit.platform.suite.api.Suite

@Suite
@SelectPackages("com.kotlin.dojo.practice.dataStructures", "com.kotlin.dojo.practice.designPatterns")
class DojoPracticeTestSuite
