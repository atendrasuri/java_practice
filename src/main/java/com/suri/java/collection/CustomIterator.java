package com.suri.java.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 23/02/19
 * @Description: (Overwrite)
 * @History:
 */
public class CustomIterator {
    public static void main(String[] args) {
        Item i1 = new Item("AAAA", 120);
        Item i2 = new Item("BBB", 130);
        Item i3 = new Item("CCCC", 140);
        Item i4 = new Item("DDDD", 150);
        Item i5 = new Item("EEEE", 160);

        ItemShop itemShop = new ItemShop();
        itemShop.add(i1);
        itemShop.add(i2);
        itemShop.add(i3);
        itemShop.add(i4);
        itemShop.add(i5);
        Iterator<Item> itr = itemShop.iterator();

        while (itr.hasNext()) {
            System.out.println(" " + itr.next());
        }

        ArrayList ar;

    }
}


class Item {
    private String item_name;
    private int item_price;

    public Item(String item_name, int item_price) {
        this.item_name = item_name;
        this.item_price = item_price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "item_name='" + item_name + '\'' +
                ", item_price=" + item_price +
                '}';
    }
}

class ItemShop implements Iterable<Item> {

    List<Item> itemList;

    public ItemShop() {
        itemList = new ArrayList<>();
    }


    @Override
    public Iterator<Item> iterator() {
        return new ItemShopIterator(itemList);
    }

    public void add(Item item) {
        itemList.add(item);
    }
}

class ItemShopIterator implements Iterator<Item> {

    List<?> itemList;
    int current_index;

    public ItemShopIterator(List<?> itemList) {
        this.itemList = itemList;
        current_index = 0;
    }


    @Override
    public boolean hasNext() {
        if (itemList.size() == 0) {
            System.out.println("list is empty");
            return false;
        } else if (current_index >= itemList.size()) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Item next() {
        if (current_index >= itemList.size()) {
            throw new NoSuchElementException();
        }
        return (Item) itemList.get(current_index++);
    }
}