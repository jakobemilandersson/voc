

import os
import sys
from unittest import expectedFailure
from .. utils import TranspileTestCase

class DateModuleTests(TranspileTestCase):
	def test_today(self):
		self.assertCodeExecution("""
		from datetime import date
		print (date.today())
		""")

	def test_creation(self):
		self.assertCodeExecution("""
		from datetime import date
		try:
			print (date(10000, 6, 3))
		except ValueError as err:
			print(err)
		""")

	def test_creation_invalid_year(self):
		self.assertCodeExecution("""
		from datetime import date
		try:
			print (date(0, 6, 3))
		except ValueError as err:
			print(err)
		""")

	def test_creation_invalid_month(self):
		self.assertCodeExecution("""
		from datetime import date
		try:
			print (date(1, 0, 3))
		except ValueError as err:
			print(err)
		""")
	
	def test_creation_invalid_day(self):
		self.assertCodeExecution("""
		from datetime import date
		try:
			print (date(1, 5, 0))
		except ValueError as err:
			print(err)
		""")

	def test_creation_null_input(self):
		self.assertCodeExecution("""
		from datetime import date
		try:
			print (date(1, None, 3))
		except TypeError as err:
			print(err)
		""")

	def test_kwargs(self):
		self.assertCodeExecution("""
		from datetime import date
		print (date(year=4, day=3, month=10))
		""")

	def test_year_attr(self):
		self.assertCodeExecution("""
		from datetime import date
		d = date(1337, 1, 1)
		print(d.year)
		""")

	def test_month_attr(self):
		self.assertCodeExecution("""
		from datetime import date
		d = date(1338, 12, 1)
		print(d.month)
		""")

	def test_day_attr(self):
		self.assertCodeExecution("""
		from datetime import date
		d = date(1339, 1, 4)
		print(d.day)
		""")
	
	def test_min_attr(self):
		self.assertCodeExecution("""
		from datetime import date
		d = date(1300, 1, 4)
		print(d.min)
		""")

	def test_max_attr(self):
		self.assertCodeExecution("""
		from datetime import date
		d = date(1300, 1, 4)
		print(d.max)
		""")

	def test_ctime(self):
		self.assertCodeExecution("""
		from datetime import date
		d = date(2018, 9, 21)
		print(d.ctime())
		""")

	def test_ctime_2(self):
		self.assertCodeExecution("""
		from datetime import date
		d = date(9191, 1, 31)
		print(d.ctime())
		""")

	def test_ctime_3(self):
		self.assertCodeExecution("""
		from datetime import date
		d = date(9491, 12, 31)
		print(d.ctime())
		""")

	def test_repr(self):
		self.assertCodeExecution("""
		from datetime import date
		d = date(9491, 12, 31)
		print(d.__repr__())
		""")

	def test_str(self):
		self.assertCodeExecution("""
		from datetime import date
		d = date(9491, 12, 31)
		print(d.__str__())
		""")


class TimedeltaModuleTests(TranspileTestCase):

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

    def test_timedelta_add1(self):
        self.assertCodeExecution("""
            from datetime import timedelta
            t1 = timedelta(days=1, hours=10, minutes=15, seconds=1)
            t2 = timedelta(days=1, hours=-5, minutes=1, microseconds=20)
            print (t1 + t2)
        """)

    def test_timedelta_bool1(self):
        self.assertCodeExecution("""
            from datetime import timedelta
            t1 = timedelta(True)
            print (t1)
        """)

    def test_timedelta_bool2(self):
        self.assertCodeExecution("""
            from datetime import timedelta
            t1 = timedelta(False)
            print (t1)
        """)

    def test_timedelta_tot_sec1(self):
        self.assertCodeExecution("""
            from datetime import timedelta
            t1 = timedelta(days=1, hours=10, minutes=15, seconds=1)
            print (t1.total_seconds())
        """)

    def test_timedelta_tot_sec2(self):
        self.assertCodeExecution("""
            from datetime import timedelta
            t1 = timedelta(microseconds=10)
            print (t1.total_seconds())
        """)

    def test_timedelta_con_bool1(self):
        self.assertCodeExecution("""
            from datetime import timedelta
            t1 = timedelta(days=True)
            print (t1)
        """)

    def test_timedelta_con_bool2(self):
        self.assertCodeExecution("""
            from datetime import timedelta
            t1 = timedelta(days=False)
            print (t1)
        """)

    def test_timedelta_con_bool3(self):
        self.assertCodeExecution("""
            from datetime import timedelta
            t1 = timedelta(days=False, hours=True, minutes=False, seconds=True)
            print (t1)
        """)
