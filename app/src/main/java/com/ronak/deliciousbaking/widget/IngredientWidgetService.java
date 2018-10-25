package com.ronak.deliciousbaking.widget;

import android.content.Intent;
import android.widget.RemoteViewsService;

public class IngredientWidgetService extends RemoteViewsService {
    @Override
    public RemoteViewsFactory onGetViewFactory(final Intent intent) {
        return new IngredientRemoteViewFactory(getApplicationContext());
    }
}
