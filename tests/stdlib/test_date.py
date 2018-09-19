

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
		print (date(1, 2, 3))
		""")

	def test_kwargs(self):
		self.assertCodeExecution("""
		from datetime import date
		print (date(year=4, day=3, month=10))
		""")