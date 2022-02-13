#include <bits/stdc++.h>
#define COUNT 10

using namespace std;

struct Node{
    int data;
    Node* left;
    Node* right;
    int height;
};

int getHeight(Node* root){
    if (root == NULL)
        return 0;
    // return 1 + max(getHeight(root -> left), getHeight(root -> right));
    return root -> height;
}

Node* rightRotate(Node* root){
    Node* x = root -> left;

    // Bắt đầu quay phải
    root -> left = x -> right;
    x -> right = root;

    // Thiết lập chiều cao
    root -> height = 1 + max(getHeight(root -> left), getHeight(root -> right));
    x -> height = 1 + max(getHeight(x -> left), getHeight(x -> right));

    // Return x - trả về root mới
    return x;
}

Node* leftRotate(Node* root){
    Node* y = root -> right;

    // Bắt đầu quay trái
    root -> right = y -> left;
    y -> left = root;

    // Thiết lập chiều cao
    root -> height = 1 + max(getHeight(root -> left), getHeight(root -> right));
    y -> height = 1 + max(getHeight(y -> left), getHeight(y -> right));

    // Return y - trả về một root mới
    return y;
}

// Insertion - AVL Tree
Node* Insert(Node* root, int value) {
    // 1. Insert
    if (root == NULL)
        return new Node { value, NULL, NULL, 1 }; // Trả về Node có height = 1
    if (value > root->data)
        root->right = Insert(root->right, value);
    else if (value < root->data)
        root->left = Insert(root->left, value);
    else
        return root; // Neu bang thi khong them
 
    // 2. Set height
    root->height = 1 + max(getHeight(root->left), getHeight(root->right));
 
    // 3. Rotate
    int valBalance = getHeight(root->left) - getHeight(root->right);
    
    // Kiểm tra 4 TH xảy ra:
    // 3.1. Left left
    if (valBalance > 1 && value < root->left->data)
        return rightRotate(root);
 
    // 3.2. Right Right
    if (valBalance < -1 && value > root->right->data)
        return leftRotate(root);
 
    // 3.3. Left Right
    if (valBalance > 1 && value > root->left->data) {
        root->left = leftRotate(root->left);
        return rightRotate(root);
    }
 
    // 3.4. Right Left
    if (valBalance < -1 && value < root->right->data) {
        root->right = rightRotate(root->right);
        return leftRotate(root);
    }
 
    return root;
}

// In - Print 2D ra console
void print2DUtil(Node* root, int space){
    if (root == NULL)
        return;
    space += COUNT;

    print2DUtil(root -> right, space);

    cout << endl;

    for (int i = COUNT; i < space; i++)
        cout << " ";
    cout << root -> data << " (" << root -> height << ") " << "\n";

    print2DUtil(root -> left, space);
}

void print2D(Node* root){
    print2DUtil(root, 0);
}

int main(){
    Node* tree = NULL;
    tree = Insert(tree, 18);
    tree = Insert(tree, 12);
    tree = Insert(tree, 30);
    tree = Insert(tree, 25);
    tree = Insert(tree, 69);
    tree = Insert(tree, 23);
    print2D(tree);
}
