from .. utils import TranspileTestCase, BuiltinFunctionTestCase, BuiltinTwoargFunctionTestCase

import unittest

class CosTests(TranspileTestCase):

    def test_cos_int(self):
        self.assertCodeExecution("""
            from math import cos
            x = 1
            try:
                print(cos(x))
            except TypeError as err:
                print(err)
        """)
