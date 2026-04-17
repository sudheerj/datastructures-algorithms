import unittest
from equilibrium_index import equilibrium_index

class TestEquilibriumIndex(unittest.TestCase):
    def test_equilibrium_index_found(self):
        self.assertEqual(equilibrium_index([1, 3, 5, 2, 2]), 2)

    def test_no_equilibrium_index(self):
        self.assertEqual(equilibrium_index([1, 2, 3]), -1)

    def test_single_element(self):
        self.assertEqual(equilibrium_index([10]), 0)

    def test_empty_array(self):
        self.assertEqual(equilibrium_index([]), -1)

if __name__ == '__main__':
    unittest.main()
