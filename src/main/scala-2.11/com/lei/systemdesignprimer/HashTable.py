class Item(object):
    def __init__(self, key, value):
        self.key = key
        self.value = value


class HashTable(object):
    def __init__(self, size):
        self.size = size
        self.data = [[] for _ in range(size)]

    def _hash_function(self, key):
        return key % self.size

    def put(self, key, value):
        idx = self._hash_function(key)
        for item in self.data[idx]:
            if item.key == key:
                item.value = value
                return
        self.data[idx].append(Item(key, value))

    def get(self, key):
        idx = self._hash_function(key)
        for item in self.data[idx]:
            if item.key == key:
                return item.value
        raise KeyError('Key not found')

    def remove(self, key):
        idx = self._hash_function(key)
        for index, item in enumerate(self.data[idx]):
            if item.key == key:
                del self.data[idx][index]
                return

