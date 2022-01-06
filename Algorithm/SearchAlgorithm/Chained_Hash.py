# 체인법으로 만든 Hash
# 파이썬에서 해시의 역할은 딕셔너리가 한다. -> 그래도 구현법을 알아두자.
import hashlib
# __future__ -> 상위버전 모듈 사용가능하게 해줌 annotations 를 사용하면 type hint를 문자열이 아닌, 일반적인 클래스 이름을 사용해 표기할 수 있다.
from __future__ import annotations 
from typing import Any, Type

# Node 클래스 (해시를 구성하는 노드)
class Node:
    # 타입 힌트는 강제되게 만들지는 않고 해당 매개변수에 무엇을 넣고 무엇이 리턴되는 지에 대한 힌트만을 제공한다. 즉 일종의 주석과 같다.
    def __init__(self, key : Any, value : Any, next : Node) -> None:
        self.key = key
        self.value = value
        self.next = next

# 체인법 해시 클래스
class ChainedHadh:
    def __init__(self, capacity : int) -> None:
        self.capacity = capacity # 해시 테이블의 크기를 지정해줌
        self.table = [None] * self.capacity # 해시 테이블 선언
    
    def hashVaule(self, key : Any) -> int:
        # 해시값을 구해주는 함수
        if isinstance(key, int):
            # isinstance 함수 : 해당하는 변수, 객체의 타입을 검사하는 함수 같으면 True 다르면 Fault 리턴
            return key % self.capacity # 해시 테이블의 크기로 나눈 나머지가 key값이 되어야 한다. -> 잘 생각해보면 이해 됨
        return(int(hashlib.sha256(str(key).encode()).hexdigest(), 16) % self.capacity)
        # key가 int형이 아닐경우 int형으로 변환해주는 과정이 필요하게 되는데 이를 수행하는게 위의 코드이다.
        # sha256 알고리즘: 주어진 바이트 문자열의 해시값을 구하는 해시 알고리즘의 생성자
        # encode 함수: key를 str로 변환 후 변환된 문자열을 encode 함수에 전달하여 문자열 생성
        # hexdigest 함수: sha256 알고리즘에서 해시값을 16진수 문자열로 꺼냄
        # int 함수: 꺼낸 16진수 문자열을 int형으로 변환
    
    def search(self, key : Any ) -> Any:
        hash = self.hashVaule(key)
        p = self.table[hash]

        p.key