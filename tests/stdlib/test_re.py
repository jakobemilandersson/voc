import unittest

from ..utils import TranspileTestCase


class ReModuleTests(TranspileTestCase):
    @unittest.expectedFailure
    def test_escape(self):
        self.assertCodeExecution("""
        import re
        print (re.escape('python.exe'))
        """)
