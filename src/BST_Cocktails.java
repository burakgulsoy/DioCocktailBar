import java.util.ArrayList;

public class BST_Cocktails {
    private TreeNode root;
    private int size;
    private ArrayList<Cocktail> cocktailArrayList = new ArrayList<>();

    public BST_Cocktails() {
        root = null;
        size = 0;
    }

    public TreeNode createNewNode(Cocktail newCocktail) {
        return new TreeNode(newCocktail);
    }

    public int getSize() {
        return size;
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public void setCocktailArrayList(ArrayList<Cocktail> cocktailArrayList) {
        this.cocktailArrayList = cocktailArrayList;
    }

    public ArrayList<Cocktail> getCocktailArrayList() {
        return cocktailArrayList;
    }

    public boolean insert(Cocktail newCocktail) {
        if (root == null) {
            root = createNewNode(newCocktail);
        } else {
            TreeNode parent = null;
            TreeNode current = root;

            while (current != null) {
                if (newCocktail.getName().compareTo(current.getElement().getName()) < 0) {
                    parent = current;
                    current = current.getLeft();
                } else if (newCocktail.getName().compareTo(current.getElement().getName()) > 0) {
                    parent = current;
                    current = current.getRight();
                } else
                    return false;
            }

            if (newCocktail.getName().compareTo(parent.getElement().getName()) < 0) {
                parent.setLeft(createNewNode(newCocktail));
            } else {
                parent.setRight(createNewNode(newCocktail));
            }
        }

        size++;
        return true;
    }

    public void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.getLeft());
        System.out.println(root.getElement() + " ");
        inorder(root.getRight());
    }

    public void inorderCreatingArrayList(TreeNode root) {
        if (root == null) {
            return;
        }

        inorderCreatingArrayList(root.getLeft());
        cocktailArrayList.add(root.getElement());
        inorderCreatingArrayList(root.getRight());
    }


    public void postorder(TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.getLeft());
        inorder(root.getRight());
        System.out.println(root.getElement() + " ");
    }

    public void preorder(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.println(root.getElement());
        inorder(root.getLeft());
        inorder(root.getRight());
    }

    public boolean delete(Cocktail cocktail) {
        TreeNode parent = null;
        TreeNode current = root;

        while (current != null) {
            if (cocktail.getName().compareTo(current.getElement().getName()) < 0) {
                parent = current;
                current = current.getLeft();
            } else if (cocktail.getName().compareTo(current.getElement().getName()) > 0) {
                parent = current;
                current = current.getRight();
            } else
               break;
        }

        if (current == null)
            return false;

        if (current.getLeft() == null) {

            if (parent == null) {
                root = current.getRight();
            } else {
                if (cocktail.getName().compareTo(parent.getElement().getName()) < 0) {
                    parent.setLeft(createNewNode(cocktail));
                } else
                    parent.setRight(createNewNode(cocktail));
            }
        } else {
            TreeNode parentOfRightMost = current;
            TreeNode rightMost = current.getLeft();
            while (rightMost.getRight() != null) {
                parentOfRightMost = rightMost;
                rightMost = rightMost.getRight();
            }

            current.setElement(rightMost.getElement());

            if (parentOfRightMost.getRight() == rightMost) {
                parentOfRightMost.setRight(rightMost.getLeft());
            } else {
                parentOfRightMost.setLeft(rightMost.getLeft());
            }
        }

        size--;
        return true;
    }

    public boolean search(Cocktail cocktail) {
        TreeNode current = root;

        while (current != null) {
            if (cocktail.getName().compareTo(current.getElement().getName()) < 0) {
                current = current.getLeft();
            } else if (cocktail.getName().compareTo(current.getElement().getName()) > 0) {
                current = current.getRight();
            } else
                return true;
        }
        return false;
    }

}
