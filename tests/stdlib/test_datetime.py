import os
import sys
from unittest import expectedFailure
from ..utils import TranspileTestCase

class TimeModuleTests(TranspileTestCase):

    #######################################################
    @expectedFailure
    def test_timedelta(self):
        self.assertCodeExecution("""
            from datetime import timedelta
            t1 = timedelta(days=1, hours=10, minutes=15, seconds=1)
            t2 = timedelta(weeks=1, days=2, hours=-5, seconds=0)
            i = 5
            print (t1 + t2)
            print (i * t1)
            print (t2.total_seconds())
        """)