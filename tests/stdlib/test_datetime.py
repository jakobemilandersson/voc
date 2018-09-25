import os
import sys
from unittest import expectedFailure
from ..utils import TranspileTestCase

class TimeModuleTests(TranspileTestCase):

    #######################################################
    def test_timedelta_con1(self):
        self.assertCodeExecution("""
            from datetime import timedelta
            t1 = timedelta(days=1, hours=10, minutes=15, seconds=1)
            print (t1)
        """)

    def test_timedelta_con2(self):
        self.assertCodeExecution("""
            from datetime import timedelta
            t1 = timedelta()
            print (t1)
        """)

    def test_timedelta_con3(self):
        self.assertCodeExecution("""
            from datetime import timedelta
            t1 = timedelta(1)
            print (t1)
        """)

    def test_timedelta_con4(self):
        self.assertCodeExecution("""
            from datetime import timedelta
            t1 = timedelta(1,0,10)
            print (t1)
        """)

    def test_timedelta_con_float1(self):
        self.assertCodeExecution("""
            from datetime import timedelta
            t1 = timedelta(1.2)
            print (t1)
        """)

    def test_timedelta_con_float2(self):
        self.assertCodeExecution("""
            from datetime import timedelta
            t1 = timedelta(1.3)
            print (t1)
        """)

    def test_timedelta_con_float3(self):
        self.assertCodeExecution("""
            from datetime import timedelta
            t1 = timedelta(0, 1.2)
            print (t1)
        """)

    def test_timedelta_con_float4(self):
        self.assertCodeExecution("""
            from datetime import timedelta
            t1 = timedelta(0, 0, 1.2)
            print (t1)
        """)

    def test_timedelta_con_float5(self):
        self.assertCodeExecution("""
            from datetime import timedelta
            t1 = timedelta(0, 0, 0, 1.2)
            print (t1)
        """)

    def test_timedelta_con_float6(self):
        self.assertCodeExecution("""
            from datetime import timedelta
            t1 = timedelta(0, 0, 0, 0, 1.2)
            print (t1)
        """)

    def test_timedelta_con_float7(self):
        self.assertCodeExecution("""
            from datetime import timedelta
            t1 = timedelta(0, 0, 0, 0, 0, 1.2)
            print (t1)
        """)

    def test_timedelta_con_float8(self):
        self.assertCodeExecution("""
            from datetime import timedelta
            t1 = timedelta(0, 0, 0, 0, 0, 0, 1.2)
            print (t1)
        """)

    def test_timedelta_con_float9(self):
        self.assertCodeExecution("""
            from datetime import timedelta
            t1 = timedelta(days=1.2)
            print (t1)
        """)


    def test_timedelta_mul1(self):
        self.assertCodeExecution("""
            from datetime import timedelta
            t1 = timedelta(days=1, hours=10, minutes=15, seconds=1)
            i = 5
            print (t1 * i)
        """)

    def test_timedelta_mul2(self):
        self.assertCodeExecution("""
            from datetime import timedelta
            t1 = timedelta(days=1, hours=10, minutes=15, seconds=1)
            i = 5
            print (i * t1)
        """)

    def test_timedelta_add2(self):
        self.assertCodeExecution("""
            from datetime import timedelta
            t1 = timedelta(days=1, hours=10, minutes=15, seconds=1)
            t2 = timedelta(days=1, hours=-5, minutes=1, microseconds=20)
            print (t1 + t2)
        """)

    def test_timedelta_tot_sec1(self):
        self.assertCodeExecution("""
            from datetime import timedelta
            t1 = timedelta(days=1, hours=10, minutes=15, seconds=1)
            print (t1.total_seconds())
        """)
