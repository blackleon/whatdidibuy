package com.example.blackleon.hf18_001;

import android.support.annotation.Nullable;
import android.support.v7.util.DiffUtil;

import java.util.List;

public class UpdateList extends DiffUtil.Callback{

        List<pickAnImage.Item> oldItems;
        List<pickAnImage.Item> newItems;

        public UpdateList(List<pickAnImage.Item> newItems, List<pickAnImage.Item> oldItems) {
            this.newItems = newItems;
            this.oldItems = oldItems;
        }

        @Override
        public int getOldListSize() {
            return oldItems.size();
        }

        @Override
        public int getNewListSize() {
            return newItems.size();
        }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return false;
    }

    @Override
        public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
            return oldItems.get(oldItemPosition).equals(newItems.get(newItemPosition));
        }

        @Nullable
        @Override
        public Object getChangePayload(int oldItemPosition, int newItemPosition) {
            //you can return particular field for changed item.
            return super.getChangePayload(oldItemPosition, newItemPosition);
        }
}
