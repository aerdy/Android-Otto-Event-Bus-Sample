package com.necisstudio.otto.manage;

import com.squareup.otto.Bus;

/**
 * Created by vim on 26/09/16.
 */

public final class EventBus {
    private static final Bus BUS = new Bus();

    public static Bus getInstance() {
        return BUS;
    }

    private EventBus() {

    }
}
