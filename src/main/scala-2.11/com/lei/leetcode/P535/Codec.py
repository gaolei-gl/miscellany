class Codec:
    import string
    letters = string.ascii_letters + string.digits
    full_tiny = {}
    tiny_full = {}
    global_counter = 0

    def encode(self, long_url):
        """Encodes a URL to a shortened URL.

        :type long_url: str
        :rtype: str
        """

        def decto62(dec):
            ans = ""
            while 1:
                ans = self.letters[dec % 62] + ans
                dec //= 62
                if not dec:
                    break
            return ans

        suffix = decto62(self.global_counter)
        if long_url not in self.full_tiny:
            self.full_tiny[long_url] = suffix
            self.tiny_full[suffix] = long_url
            self.global_counter += 1
        return "http://tinyurl.com/" + suffix

    def decode(self, short_url):
        """Decodes a shortened URL to its original URL.

        :type short_url: str
        :rtype: str
        """
        idx = short_url.split('/')[-1]
        if idx in self.tiny_full:
            return self.tiny_full[idx]
        else:
            return None
