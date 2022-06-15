//node 구현
function Node(element) {
    this.element = element;
    this.next = null;
}
//Linkde List 구현
function LinkedList() {
    this.head = new Node("head");
    this.find = find;
    this.append = append;
    this.insert = insert;
    this.remove = remove;
    this.toString = toString;
    this.findPrevious = findPrevious;
}
//node 찾기
function find(item) {
    let currNode = this.head;
    while (currNode.element != item) {
        currNode = currNode.next;
    }
    return currNode;
}
//이전 노드 찾기
function findPrevious(item) {
    let currNode = this.head;
    while (currNode.next != null && currNode.next.element != item) {
        currNode = currNode.next;
    }
    return currNode;
}
//노드추가
function append(newElement) {
    let newNode = new Node(newElement);
    let current = this.head;
    while (current.next != null) {
        current = current.next;
    }
    current.next = newNode;
}
//노드 중간 삽입
function insert(newElement, item) {
    let newNode = new Node(newElement);
    let current = this.find(item);
    newNode.next = current.next;
    current.next = newNode;
}
//노드 삭제
function remove(item) {
    let preNode = this.findPrevious(item);
    preNode.next = preNode.next.next;
}
//연결 리스트의 요소들을 출력
function toString() {
    let str = "[ ";
    let currNode = this.head;
    while (currNode.next != null) {
        str += currNode.next.element + ' ';
        currNode = currNode.next;
    }
    return str + ']';
}

let linkedlist = new LinkedList();
linkedlist.insert("A", "head");
linkedlist.insert("B", "A");
linkedlist.insert("C", "B");
linkedlist.remove("B");
linkedlist.append("D")
linkedlist.append("E")

console.log(linkedlist.toString());