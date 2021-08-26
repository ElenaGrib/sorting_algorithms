package com.company.trees;

import java.util.Stack;

public class Tree {
    public static void main(String[] args) {
        Tree root =
                new Tree(50,
                        new Tree(40,
                                new Tree(30, null, new Tree(20)), new Tree(9)),
                        new Tree(39,
                                new Tree(38, new Tree(8), new Tree(5, new Tree(4), null)),
                                new Tree(23, new Tree(48), new Tree(11))));

        System.out.println("Recursive sum: " + root.sumRecursive());
        System.out.println("Iterative sum: " + sumIterative(root));

    }

    //у дерева есть узел и два потомка, которые в свою очередь являются деревьями (поддеревьями)
    int value;
    Tree left;
    Tree right;

    public Tree(int value, Tree left, Tree right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    //пустой конструктор для создания листов (дерево без потомков)
    public Tree(int value) {
        this.value = value;
    }

    //рекурсивный метод для нахождения суммы всех узлов дерева
    //РЕКУРСИВНЫЙ ОБХОД В ГЛУБИНУ (от узла вниз по ветке, ждем, назад к узлу)
    public int sumRecursive() {
        int summ = value;

        //если левое поддерево не пустое, то прибавляем к сумме сумму левого потомка
        if (left != null) {
            summ += left.sumRecursive();
        }

        if (right != null) {
            summ += right.sumRecursive();
        }

        return summ;
    }

    //ИТЕРАТИВНЫЙ ОБХОД В ГЛУБИНУ
    //вместо рекурсии мы тут добавляем левый или правый эл-в в стек

    //если заменить стек НА ОЧЕРЕДЬ, то обходим дерево по уровням, не в низ, а слева на право,
    //т.е. получим алгоритм обхода В ШИРИНУ, порядок входа и выхода эл-в меняется, можно применять для поиска ближайшего к корню эл-та
    public static int sumIterative(Tree root) {
        Stack<Tree> stack = new Stack<>();
        stack.push(root);

        int summ = 0;

        while (!stack.isEmpty()) { //пока стек не пустой
            Tree node = stack.pop(); //достаем узел из стека
            summ += node.value;


            if (node.right != null) {//если у усла есть правый потомок
                stack.push(node.right);//то также добавляем его в стек
            }

            if (node.left != null) {//если у усла есть левый потомок
                stack.push(node.left);//то также добавляем его в стек
            }
        }
        return summ;
    }
}
