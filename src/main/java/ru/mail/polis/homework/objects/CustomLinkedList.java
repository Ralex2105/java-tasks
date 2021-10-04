package ru.mail.polis.homework.objects;

/**
 * Реализовать все методы односвязанного списка.
 */
public class CustomLinkedList {

    private Node head;

    /**
     * Реализовать метод:
     * Добавляет элемент в односвязны список.
     *
     * @param value - data for create Node.
     */
    public void add(int value) {
        Node newNode = new Node(value);
        newNode.value = value;
        if (head != null) {
            newNode.setNext(head);
        }
        head = newNode;
    }

    /**
     * Реализовать метод:
     * Удаляет элемент в указанной позиции, при это связывая его соседние элементы друг с другом.
     * Если был передан невалидный index - надо выкинуть исключение IndexOutOfBoundsException.
     *
     * @param index - position what element need remove.
     */
    public void removeElement(int index) {
        try {
            if (head == null) {
                throw new IndexOutOfBoundsException();
            }
            Node node = head;
            if (index == 0) {
                head = node.next;
                return;
            }
            for (int i = 0; node != null && i < index - 1; ++i) {
                node = node.next;
            }
            if (node == null || node.next == null) {
                throw new IndexOutOfBoundsException();
            }
            node.setNext(node.next.next);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Реализовать метод:
     * Переварачивает все элементы списка.
     * Пример:
     * исходная последовательность списка "1 -> 2 -> 3 -> 4 -> null"
     * После исполнения метода последовательность должа быть такой "4 -> 3 -> 2 -> 1 -> null"
     */
    public void revertList() {
        Node previousNode = null;
        Node lastNode = head;
        while (lastNode != null) {
            Node next = lastNode.next;
            lastNode.setNext(previousNode);
            previousNode = lastNode;
            lastNode = next;
        }
        head = previousNode;
    }

    /**
     * Метод выводит всю последовательность хранящуюся в списке начиная с head.
     * Формат вывода:
     *  - значение каждой Node должно разделяться " -> "
     *  - последовательность всегда заканчивается на null
     *  - если в списке нет элементов - верните строку "null"
     *
     * @return - String with description all list
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        Node node = this.head;
        while (node != null) {
            result.append(node.value).append(" -> ");
            node = node.next;
        }
        result.append("null");
        return result.toString();
    }

    private static class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
