

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
		print (date(1, None, 3))
		""")