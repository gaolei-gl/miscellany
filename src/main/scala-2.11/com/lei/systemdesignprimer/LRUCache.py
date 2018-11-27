class Item(object):
    def __init__(self, k, v):
        self.key = k
        self.value = v


class LRUCache(object):

    def __init__(self, size):
        self.size = size
        self.dict = dict()
        self.linked_list = []

    def _update_lru(self, key):
        for idx, item in enumerate(self.linked_list):
            if key == item:
                del self.linked_list[idx]
                self.linked_list.insert(0, key)
                return
        self.linked_list.insert(0, key)

    def get(self, key):
        if key in self.dict:
            v = self.dict.get(key)
            self._update_lru(key)
            return v

    def _evicate_if_needed(self):
        if len(self.linked_list) > self.size:
            print "evicting now...."
            print self.linked_list
            print self.dict
            keys = self.linked_list[self.size:]
            self.linked_list = self.linked_list[:self.size]
            for k in keys:
                del self.dict[k]

            print "after evict."
            print self.dict

    def set(self, key, value):
        self.dict[key] = value
        self._update_lru(key)
        self._evicate_if_needed()


if __name__ == '__main__':
    cache = LRUCache(3)
    cache.set(1, "one")
    cache.set(2, "two")
    cache.set(3, "three")
    cache.get(1)
    cache.set(4, "four")

# linked list ordered by least recent usage
# key2 -> key1 -> key3 -> null

# for instant fetch, alter linked list after read or write
# map
# {
#     key1 -> value
# key2 -> value
# key3 -> value
# }
