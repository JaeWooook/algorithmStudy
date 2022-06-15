//graph uion&find
const v = 6,
    e = 4;
// const parent = Array(v + 1).fill(0);
const parent = [0, 1, 2, 3, 4, 5, 6];

function find_parent(parent, x) { //일반적인 find
    if (parent[x] !== x) {
        return find_parent(parent, parent[x]);
    }
    return x;
}

function union_parent(parent, a, b) {
    a = find_parent(parent, a);
    b = find_parent(parent, b);

    if (a < b) {
        parent[b] = a;
    } else {
        parent[a] = b;
    }
}
union_parent(parent, 1, 4);
union_parent(parent, 2, 3);
union_parent(parent, 2, 4);
union_parent(parent, 5, 6);

process.stdout.write("각 원소가 속한 집합: ");
for (let i = 1; i < v + 1; i++) {
    process.stdout.write(`${find_parent(parent, i)} `);
}

console.log();

process.stdout.write("부모 테이블: ");

for (let i = 1; i < v + 1; i++) {
    process.stdout.write(`${parent[i]} `);
}
console.log();

//개선된 코드

const v2 = 6,
    e2 = 4;
const parent2 = [0, 1, 2, 3, 4, 5, 6];

function find_parent_two(parent2, x) { //경로 압축 기법
    // console.log("this parent2[x],x", parent2[x], x);
    if (parent2[x] !== x) {
        parent2[x] = find_parent_two(parent2, parent2[x]);
    }
    return parent2[x];
}

function union_parent_two(parent2, a, b) {
    a = find_parent_two(parent2, a);
    b = find_parent_two(parent2, b);

    if (a < b) {
        parent2[b] = a;
    } else {
        parent2[a] = b;
    }
}
union_parent_two(parent2, 1, 4);
union_parent_two(parent2, 2, 3);
union_parent_two(parent2, 2, 4);
union_parent_two(parent2, 5, 6);
// console.log("check", parent2);
process.stdout.write("각 원소가 속한 집합: ");
for (let i = 1; i < v + 1; i++) {
    process.stdout.write(`${find_parent_two(parent2, i)} `); //다시한번 필터링해준다.
}

console.log();

process.stdout.write("부모 테이블: ");

for (let i = 1; i < v + 1; i++) {
    process.stdout.write(`${parent2[i]} `);
}