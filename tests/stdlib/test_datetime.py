from unittest import expectedFailure

from ..utils import TranspileTestCase

class DateTimeConstructor(TranspileTestCase):	
	# Valid arguments to constructor
	def test__new__three_arg(self):
		self.assertCodeExecution("""
		from datetime import datetime
		dt = datetime(2001,1,1)
		print(dt)
		""")

	def test__new__four_arg(self):
		self.assertCodeExecution("""
		from datetime import datetime
		dt = datetime(2001, 1, 2, 11)
		print(dt)
		""")

	def test__new__five_arg(self):
		self.assertCodeExecution("""
		from datetime import datetime
		dt = datetime(2001, 1, 2, 11, 30)
		print(dt)
		""")

	def test__new__six_arg(self):
		self.assertCodeExecution("""
		from datetime import datetime
		dt = datetime(2001, 1, 2, 11, 25)
		print(dt)
		""")
		
	#Invalid arguments to constructor

	def test___new__zero_arg(self):
		self.assertCodeExecution("""
		from datetime import datetime
		
		try:
			dt = datetime()
			print(dt)
		except TypeError:
			pass
		""")
	

	def test__new__one_arg(self):
		self.assertCodeExecution("""
		from datetime import datetime
		try: dt = datetime(2001)
		except TypeError:
			pass
		""")


	def test__new__two_arg(self):
		self.assertCodeExecution("""
		from datetime import datetime
		try:
			dt = datetime(2001, 12)
		except TypeError:
			pass
		""")
		
	def test__new__wrong_args(self):
		self.assertCodeExecution("""
		from datetime import datetime
		try:
			dt = datetime("e", "t", "t", "r", "o", "l", "g")
			print(dt)
		except TypeError:
			pass
		""")
		
	def test__new__wrong_year(self):
		self.assertCodeExecution("""
		from datetime import datetime
		try:
			dt = datetime(-1, 1, 1)
			print(dt)
		except ValueError:
			pass
		""")

	def test__new__wrong_month(self):
		self.assertCodeExecution("""
		from datetime import datetime
		try:
			dt = datetime(2001, 13, 1)
			print(dt)
		except ValueError:
			pass
		""")

	def test__new__wrong_day(self):
		self.assertCodeExecution("""
		from datetime import datetime
		try:
			dt = datetime(2001, 12, -1)
			print(dt)
		except ValueError:
			pass
		""")
	
	def test_new_leap_day(self):
		self.assertCodeExecution("""
		from datetime import datetime
		dt = datetime(2016, 2, 29)
		print(dt)
		""")

	def test_new_incorrect_leap_day(self):
		self.assertCodeExecution("""
		from datetime import datetime
		try:
			dt = datetime(2017, 2, 29)
			print(dt)
		except ValueError:
			pass
		""")