package com.creative.uienginesampleapp.robots

import com.sehmi.engine.core.ComposeRuleScope
import com.sehmi.engine.actions.*
import com.sehmi.engine.assertions.*

class ScrollingRobot : ComposeRuleScope {

    fun scrollTo(containerTag: String, index: Int) {
        scrollToIndex(containerTag, index)
    }

    fun swipeToLast() {
        scrollToTag("lazy_footer")
//        swipeUntilVisible("list_list", direction = Direction.DOWN, maxSwipes = 20)
        // Fixed the issue inside the engine. By default, engine was loooking for
        // "root" tag to swipe on which did not exists.
        // new release will fix this issue.
    }
}
