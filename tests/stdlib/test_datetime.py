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
	
	def test__new__leap_day(self):
		self.assertCodeExecution("""
		from datetime import datetime
		dt = datetime(2016, 2, 29)
		print(dt)
		""")

	def test__new__incorrect_leap_day(self):
		self.assertCodeExecution("""
		from datetime import datetime
		try:
			dt = datetime(2017, 2, 29)
			print(dt)
		except ValueError:
			pass
		""")
	
	
	def test__new__bool_true(self):
		self.assertCodeExecution("""
		from datetime import datetime
		try:
			dt = datetime(2017, True, 29)
			print(dt)
		except ValueError:
			pass
		""")
	
	
	def test__new__bool_false(self):
		self.assertCodeExecution("""
		from datetime import datetime
		try:
			dt = datetime(2017, 2, False)
			print(dt)
		except ValueError:
			pass
		""")
	
	
	def test__new__array(self):
		self.assertCodeExecution("""
		from datetime import datetime
		try:
			dt = datetime(2017, 2, [1337])
			print(dt)
		except TypeError:
			pass
		""")
		
	
	def test__new__float(self):
		self.assertCodeExecution("""
		from datetime import datetime
		try:
			dt = datetime(2017, 2, 13.37)
			print(dt)
		except TypeError:
			pass
		""")
	
	def test__new__complex(self):
		self.assertCodeExecution("""
		from datetime import datetime
		try:
			dt = datetime(2017, 2, 13+37j)
			print(dt)
		except TypeError:
			pass
		""")
	
	def test__new__dict(self):
		self.assertCodeExecution("""
		from datetime import datetime
		try:
			dt = datetime(2017, 2, {})
			print(dt)
		except TypeError:
			pass
		""")
		
	@expectedFailure
	def test__new__overflow(self):
		self.assertCodeExecution("""
		from datetime import datetime
		try:
			dt = datetime(2017, 2, 9999999999)
			print(dt)
		except OverflowError:
			pass
		""")
		