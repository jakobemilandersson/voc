from .. utils import TranspileTestCase, BuiltinFunctionTestCase, BuiltinTwoargFunctionTestCase

from unittest import expectedFailure

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

    @expectedFailure
    def test_cos_double(self):
        self.assertCodeExecution("""
            from math import cos
            x = 1.23
            try:
                print(cos(x))
            except TypeError as err:
                print(err)
        """)

    @expectedFailure
    def test_cos_char(self):
        self.assertCodeExecution("""
            from math import cos
            x = 'a'
            try:
                print(cos(x))
            except TypeError as err:
                print(err)
        """)
