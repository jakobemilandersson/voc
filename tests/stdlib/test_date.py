

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
